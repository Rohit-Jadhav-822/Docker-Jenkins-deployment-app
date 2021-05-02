pipeline {
    agent any
	
	  tools
    {
       maven "Maven"
    }
   stages {
      stage('checkout') {
           steps {
             
                git branch: 'master', url: 'https://github.com/Rohit-Jadhav-822/Spring-boot-actuator.git'
             
          }
        }
	 stage('Execute Maven') {
           steps {
             
                sh 'mvn package'             
          }
        }
        

       stage('Docker Build and Tag') {
           steps {
              
                sh 'docker build -t spring-boot-actuator:1.0.1 .' 
                sh 'docker tag samplewebapp 21041993/spring-boot-actuator:1.0.1'
               
          }
        }
     
  stage('Publish image to Docker Hub') {
          
            steps {
        withDockerRegistry([ credentialsId: "Docker-Credentials", url: "" ]) {
          sh  'docker push 21041993/spring-boot-actuator:1.0.1'
        }
                  
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
			{
                sh "docker run -d -p 8003:8080 21041993/spring-boot-actuator:1.0.1"
 
            }
        }
    }
}
