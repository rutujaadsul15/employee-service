pipeline {
	agent any

	environment {
		mavenHome = tool 'jenkins-maven'
	}

	tools {
		jdk 'java-17'
	}

	stages {

		stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}

		stage('publish') {
			steps {
			    bat "mvn jar:jar deploy:deploy"
			}
		}
         stage('Deploy') {
             steps {
                 script {
                     // Hardcoded credentials
                     def username = 'root'
                     def password = 'VZs@makh8Z#Ge'
                     def serverAddress = '103.171.181.190'

                     // Connect to Linux server using SSH with password
                     sh "sshpass -p '${password}' ssh -o StrictHostKeyChecking=no ${username}@${serverAddress}"

                     // Copy JAR from Jenkins workspace to Linux server
                     sh "sshpass -p '${password}' scp -o StrictHostKeyChecking=no C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\spring-jenkins\\target\\employee-service-0.0.1-SNAPSHOT.jar ${username}@${serverAddress}:/home/pickmyparcel/public_html/backend"

                     // Run JAR on Linux server
                     //sh "sshpass -p '${password}' ssh -o StrictHostKeyChecking=no ${username}@${serverAddress} 'java -jar /home/pickmyparcel/public_html/backend/employee-service-0.0.1-SNAPSHOT.jar'"
                 }
             }
      }
	}
}