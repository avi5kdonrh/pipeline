FROM FROM @fromImage@:latest-java11
ENV JAVA_APP_DIR=/deployments
LABEL org.label-schema.description="Spring Boot example running a Camel route connecting to EnMasse" org.label-schema.version=7.11.1.fuse-sb2-7_11_1-00014-redhat-00002 org.label-schema.schema-version=1.0 org.label-schema.build-date=2023-02-03T15:12:28.366184 org.label-schema.name="Fabric8 :: Quickstarts :: Spring Boot :: Camel and EnMasse" org.label-schema.vcs-ref=eda26f715f1b0029f0b825f01c10bed84437072c org.label-schema.vcs-url=https://github.com/avi5kdonrh/pipeline.git
EXPOSE 8080 8778 9779
COPY /deployments /deployments/
