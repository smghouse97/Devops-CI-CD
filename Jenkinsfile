pipeline {
  agent any

  environment {
    DOCKERHUB_CREDENTIALS = credentials('docker-hub-cred')
    REMOTE_SERVER = '3.208.31.93'
    REMOTE_USER = 'ubuntu'
  }

  // Fetch code from GitHub

  stages {
    stage('checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/smghouse97/Devops-CI-CD'
      }
    }

   // Build Java application

    stage('Maven Build') {
      steps {
        sh 'mvn clean install'
      }

     // Post building archive Java application

      post {
        success {
          archiveArtifacts artifacts: '**/target/*.jar'
        }
      }
    }

  // Test Java application

    stage('Maven Test') {
      steps {
        sh 'mvn test'
      }
    }

   // Build docker image in Jenkins

    stage('Build Docker Image') {

      steps {
        sh 'docker build -t javawebapp:latest .'
        sh 'docker tag javawebapp mdghouse97/java-web-app:latest'
      }
    }

   // Login to DockerHub before pushing docker Image

    stage('Login to DockerHub') {
      steps {
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
      }
    }

   // Push image to DockerHub registry

    stage('Push Image to dockerHUb') {
      steps {
        sh 'docker push mdghouse97/java-web-app:latest'
      }
      post {
        always {
          sh 'docker logout'
        }
      }

    }

   // Pull docker image from DockerHub and run in EC2 instance 

    stage('Deploy Docker image to EC2 instance') {
      steps {
        script {
          sshagent(credentials: ['ec2-cred']) {
          sh "ssh -o StrictHostKeyChecking=no ${REMOTE_USER}@${REMOTE_SERVER} 'docker stop javaApp || true && docker rm javaApp || true'"
      sh "ssh -o StrictHostKeyChecking=no ${REMOTE_USER}@${REMOTE_SERVER} 'docker pull mdghouse97/java-web-app'"
          sh "ssh -o StrictHostKeyChecking=no ${REMOTE_USER}@${REMOTE_SERVER} 'docker run --name javaApp -d -p 8081:8081 mdghouse97/java-web-app'"
          }
        }
      }
    }
  }
}
