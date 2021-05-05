pipeline {
    agent any
	
	  tools
    {
       maven "Maven-3.8.1"
    }
   stages {
      stage('checkout') {
           steps {
             
                git branch: 'master', url: 'https://github.com/Rohit-Jadhav-822/Spring-boot-actuator.git'
             
          }
        }
	
	stage('Run tests') {
           steps {
             
                bat 'mvn test'             
          }
        }	

	stage('Execute Maven') {
           steps {
             
                bat 'mvn package'             
          }
        }
        

       stage('Docker Build and Tag') {
           steps {
              
                bat 'docker build -t spring-boot-actuator .' 
                bat 'docker tag spring-boot-actuator 21041993/spring-boot-actuator:1.0.1'
               
          }
        }
     
        stage('Publish image to Docker Hub') {
          
            steps {
        withDockerRegistry([ credentialsId: "Docker-Credentials", url: "" ]) {
              bat 'docker push 21041993/spring-boot-actuator:1.0.1'
        }
                  
          }
        }
     
        stage('Run Docker container on Jenkins Agent') {
             
            steps {
                bat "docker run -d -p 8003:8080 21041993/spring-boot-actuator:1.0.1"
 
            }
        }
    }
     post { 
        always { 
          junit 'test-results.xml'   
        }
    }
    
}
