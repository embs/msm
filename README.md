# msm

Message-Oriented Middleware for Microservices Environments

### Components

msm itself runs as a bunch of microservices. It's composed by the following
components:

- msm-sc: a container sidecar service for each service relying on msm

Head for the component subdir for more info about them (inside their READMEs).

### Developers Guidelines

#### Commit messages

Inspire your messages with these guidelines:

- [GNOMEs][gnome-commit-messages]
- [Coalas][coala-commit-messages]

It'd be nice to state the component you're modifying as a prefix in the summary:

> msm-sc: Tear things apart

[gnome-commit-messages]: https://wiki.gnome.org/Git/CommitMessages
[coala-commit-messages]: http://api.coala.io/en/latest/Developers/Writing_Good_Commits.html
