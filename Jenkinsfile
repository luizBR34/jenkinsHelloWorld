pipeline {
	agent any
	stages {
		stage("Cleaning Stage") {
			steps {
				echo "mvn clean"
			}
		}
		stage("Testing Stage") {
			steps {
				echo "mvn test"
			}
		}
		stage("Packaging Stage") {
			steps {
				echo "mvn package"
			}
		}
		stage("Consolidate Results") {
			steps {
				input("Do you want to capture results?")
				junit '**/target/surefire-reports/TEST-*.xml'
				archive 'target/*.jar'
			}
		}
		stage("Email Build Status"){
			steps {
				mail body: "${env.JOB_NAME}  - Build # ${env.BUILD_NUMBER}  - ${currentBuild.currentResult} \n\nCheck console output at ${env.BUILD_URL} to view the results.", subject: "${env.JOB_NAME}  - Build # ${env.BUILD_NUMBER}  - ${currentBuild.currentResult}!!", to: 'luizfernandomail@gmail.com'
			}
		}
	}
}
