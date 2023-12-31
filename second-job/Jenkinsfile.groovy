pipeline {
    agent none
    stages {
        stage('Back-end') {
            agent {
                docker { image 'maven:3.8.1-adoptopenjdk-11' }
            }
            steps {
                script {
                    sh 'echo "public class HelloWorld { public static void main (String[] args) { System.out.println(\\"Hello, World!!\\"); } }" > HelloWorld.java'
                    sh 'javac HelloWorld.java'
                    sh 'java HelloWorld'
                }
            }
        }
        stage('Front-end') {
            agent {
                docker { image 'node:16-alpine' }
            }
            steps {
                script {
                    echo "Hello, World!"
                }
            }
        }
    }
}
