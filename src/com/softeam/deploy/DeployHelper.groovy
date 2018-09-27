public class DeployHelper {

    DeployHelper instance = new DeployHelper();

    private DeployHelper() {

    }


    void configureGIT(sh) {
        sh 'mkdir /root/.ssh'

        sh 'cp /home/jenkins/.ssh/id_rsa /root/.ssh/id_rsa'
        sh 'cp /home/jenkins/.ssh/id_rsa.pub /root/.ssh/id_rsa.pub'

        sh 'echo "StrictHostKeyChecking no" > /root/.ssh/config'

        sh 'chmod 600 /root/.ssh/id_rsa'
        sh 'chmod 644 /root/.ssh/id_rsa.pub'
        sh 'chmod 644 /root/.ssh/config'

        sh 'git config --global user.email "startech.ouest@gmail.com"'
        sh 'git config --global user.name "Jenkins Release"'
    }
}