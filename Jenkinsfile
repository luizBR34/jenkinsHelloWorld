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
	}
}
