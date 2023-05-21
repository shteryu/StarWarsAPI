steps:
  - name: 'maven:3.9-amazoncorretto-17'
    entrypoint: mvn
    args:
      - package
      - '-Dmaven.test.skip=true'
  - name: gcr.io/cloud-builders/docker
    args:
      - build
      - '-t'
      - 'gcr.io/spring-project-385812/star_wars:$COMMIT_SHA'
      - .
  - name: gcr.io/cloud-builders/docker
    args:
      - push
      - 'gcr.io/spring-project-385812/star_wars:$COMMIT_SHA'
  - name: gcr.io/google.com/cloudsdktool/cloud-sdk
    entrypoint: gcloud
    args:
      - run
      - deploy
      - star_wars
      - '--image'
      - 'gcr.io/spring-project-385812/star_wars:$COMMIT_SHA'
      - '--region'
      - europe-west3
images:
  - 'gcr.io/spring-project-385812/star_wars:$COMMIT_SHA'
options:
  logging: CLOUD_LOGGING_ONLY
