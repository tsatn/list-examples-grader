
rm -rf student-submission


#clone to local
git clone $1 student-submission
echo 'finished cloning'


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
echo "Running tests..."
java -cp .:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > error.txt

cat error.txt
faliure =$(grep -i "Failures:" error.txt)

if[[$faliure == ""]]
then 
echo "You are Good, all test passd"
fi



