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
                     def jarFilePath = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\spring-jenkins\\target\\employee-service-0.0.1-SNAPSHOT.jar'
                     def destinationPath = '/home/pickmyparcel/public_html/backend'

                     // Copy JAR from Jenkins workspace to Linux server using plink and pscp
                     sh "echo y | plink.exe -ssh -pw ${password} ${username}@${serverAddress} pscp.exe -pw ${password} ${jarFilePath} ${username}@${serverAddress}:${destinationPath}"

                     // Run JAR on Linux server using plink
                     // Add the command to run the JAR on the server if needed
                     // sh "echo y | plink.exe -ssh -pw ${password} ${username}@${serverAddress} java -jar ${destinationPath}/employee-service-0.0.1-SNAPSHOT.jar"
                 }
             }
         }
	}
}