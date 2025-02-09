pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run') {
            steps {
                script {
                    echo "🔄 기존 애플리케이션 종료..."
                    sh 'fuser -k 9090/tcp || true'

                    echo "🚀 새로운 애플리케이션 실행 (포트: 9090)"
                    // JAVA_HOME2로 JDK 1.8을 실행
                    sh '${JAVA_HOME2}/bin/java -jar target/haven-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod --server.port=9090 > logs.txt 2>&1 &'

                    echo "⏳ 서버 시작 대기..."
                    sleep 5

                    echo "🔍 서버 상태 확인..."
                    sh 'curl -I http://localhost:9090 || echo "Server failed to start!"'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'curl -I http://localhost:9090 || echo "Server failed to start!"'
                }
            }
        }
    }

    post {
        always {
            echo "Cleaning up..."
            cleanWs()
        }
    }
}
