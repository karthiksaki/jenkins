pipeline {
  agent none
  stages {
    stage('Back-end') {
      agent {
        docker { image 'maven:3.8.1-adoptopenjdk-11' }
      }
      steps {
        script {
            public class HelloWorld {
                public static void main (String[] args) {
                    System.out.println("Hello, World!!");
                }
            }
        }
      }
    }
    stage('Front-end') {
      agent {
        docker { image 'node:16-alpine' }
      }
      steps {
        script {
            console.log("Hello, World!")
        }
      }
    }
  }
}
