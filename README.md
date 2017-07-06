# msm

Message-Oriented Middleware for Microservices Environments

### Components

msm itself runs as a bunch of microservices. It's composed by the following
components:

- msm-sc: a container sidecar service for each service relying on msm
  - msm-jsc: the current (Java) implementation for the sidecar
- msm-sdw: a listener for services arrivals who writes to etcd
- msm-sdf: a service for finding other services

Head for the component subdir for more info about them (inside their READMEs).

### Docker

Docker can be used for running msm components and dependencies. Check out
instructions about running each component through Docker within their READMEs.
Some of the sections below guide on how to run some dependencies.

Setup Docker network (common to msm components and dependencies):

    $ docker network create msm

### Kafka

msm depends on kafka for providing some services (e.g.: Service Discovery). This
dependency may be easily provided through docker with

    $ ./run-kafka

### etcd

msm depends on etcd for providing service discovery. There is a script for
easily bootstrapping one etcd node within a Docker-managed container:

    $ ./run-etcd

### Ports

Default port numbers for msm services are settled as follows

- msm-sc: 9001
- msm-sdw: 9002
- msm-sdf: 9003

### Developers Guidelines

#### Commit messages

Inspire your messages with these guidelines:

- [GNOMEs][gnome-commit-messages]
- [Coalas][coala-commit-messages]

It'd be nice to state the component you're modifying as a prefix in the summary:

> msm-sc: Tear things apart

[gnome-commit-messages]: https://wiki.gnome.org/Git/CommitMessages
[coala-commit-messages]: http://api.coala.io/en/latest/Developers/Writing_Good_Commits.html
