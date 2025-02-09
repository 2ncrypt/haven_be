pipeline {
    agent any

    environment {
        JAVA_HOME = "/usr/lib/jvm/java-8-openjdk-amd64"  // Java 1.8 환경 변수 설정
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Git에서 소스 코드 가져오기
                    echo "🔄 Checkout source code from Git repository"
                    checkout scm
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    // Maven 빌드 실행 (빌드 후 .jar 파일 생성)
                    echo "🛠️ Building the project using Maven"
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Run') {
            steps {
                script {
                    // 서버 실행 (포트 9090으로 실행)
                    echo "🚀 Starting the server on port 9090"
                    sh '''
                        nohup java -jar target/haven-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod --server.port=9090 > logs.txt 2>&1 &
                    '''
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // 서버가 실행되는지 확인
                    echo "🔍 Verifying if the server is running"
                    sh '''
                        sleep 5  # 서버가 시작될 때까지 잠시 대기
                        curl -I http://localhost:9090 || echo "❌ Server failed to start!"
                    '''
                }
            }
        }
    }

    post {
        always {
            // 항상 실행할 부분 (로그 확인, 정리 등)
            echo "🧹 Cleaning up workspace"
            cleanWs()
        }

        success {
            echo "✅ Build and deployment were successful!"
        }

        failure {
            echo "❌ Something went wrong. Check the logs for more details."
        }
    }
}
