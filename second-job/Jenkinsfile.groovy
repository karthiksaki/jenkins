pipeline{
    agent none {
        stages{
            stage('stage-1'){
                agent{
                docker{ image 'maven:3.8.1-adoptopenjdk-11'}
                }
            }
            steps{
                sh 'mvn--version'
            }
            stage('stage-2'){
                agent{
                    docker{ image 'node:16-alpine' }
                }
            steps{
                sh 'node-version'
            }
            }
        }
    }
}
