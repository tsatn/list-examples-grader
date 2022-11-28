#clone to local
if [ -d 'student-submission' ]
then
	rm -rf student-submission
	echo 'old submission purged'
fi

if [ ! $# -eq 0 ]
then
	git clone $1 student-submission
	echo 'finished cloning'
else
	echo 'no repo supplied'
fi

#check file exist
if [ ! -e 'student-submission/ListExamples.java' ]
then
	echo 'ListExamples.java missing from submission'
	exit
fi

#copy test to submission folder
cp TestListExamples.java student-submission 
echo "setup test cases"

#compile
set -e
javac -classpath "lib/*" -d student-submission student-submission/*.java
echo "Succesfully Compiled"

#run junit
