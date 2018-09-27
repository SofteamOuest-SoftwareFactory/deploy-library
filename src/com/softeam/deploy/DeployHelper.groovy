package com.softeam.deploy;

public class DeployHelper implements Serializable {

    //public static final DeployHelper instance = new DeployHelper()

    /* private DeployHelper() {

    } */

    def steps

    public DeployHelper(steps) { this.steps = steps }


    public void configureDockerRegistry() {
        steps.sh 'mkdir /etc/docker'

        // le registry est insecure (pas de https)
        steps.sh 'echo {"insecure-registries" : ["registry.k8.wildwidewest.xyz"]} > /etc/docker/daemon.json'

    }

    public void configureGIT() {
        steps.sh 'mkdir /root/.ssh'

        steps.sh 'cp /home/jenkins/.ssh/id_rsa /root/.ssh/id_rsa'
        steps.sh 'cp /home/jenkins/.ssh/id_rsa.pub /root/.ssh/id_rsa.pub'

        steps.sh 'echo "StrictHostKeyChecking no" > /root/.ssh/config'

        steps.sh 'chmod 600 /root/.ssh/id_rsa'
        steps.sh 'chmod 644 /root/.ssh/id_rsa.pub'
        steps.sh 'chmod 644 /root/.ssh/config'

        steps.sh 'git config --global user.email "startech.ouest@gmail.com"'
        steps.sh 'git config --global user.name "Jenkins Release"'
    }
}