import javaposse.jobdsl.dsl.DslFactory

job('get_containers') {
    scm {
        git('https://github.com/Yd74/Elbit.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Yarin Dolev')
            node / gitConfigEmail('yarshar7474@gmail.com')
        }
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('yarshar/getcontainers')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            buildContext('get_containers')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

job('nginx_proxy_to_get_containers') {
    scm {
        git('https://github.com/Yd74/Elbit.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Yarin Dolev')
            node / gitConfigEmail('yarshar7474@gmail.com')
        }
    }

    steps {
        dockerBuildAndPublish {
            repositoryName('yarshar/nginxproxytogetcontainers')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            buildContext('nginx_proxy_to_get_containers')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

job('run_two_containers') {
  // other configuration options
  steps {
    powerShell('docker run --net elbit-net -v /var/run/docker.sock:/var/run/docker.sock -d --name getcontainers yarshar/getcontainers:latest')
    powerShell('docker run --net elbit-net -v /var/run/docker.sock:/var/run/docker.sock -d -p 80:80 yarshar/nginxproxytogetcontainers:latest')
    powerShell('curl localhost:80')
  }
}