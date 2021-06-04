# Contribution Guidelines and Standards

Thank you for contributing to this project. :smile:

> The following are mostly guidelines, not rules. Use your best judgement, and
> feel free to propose changes to this doc.

Before contributing a pull request for [review](https://github.com/j143/query-spanner-with-java/pulls),
let's make sure the changes are consistent with the guidelines and coding style.

## General Guidelines and Philosophy for contribution

*   Inclusion of unit tests when contributing new features, will help
    1. prove that the code works correctly, and
    2. guard against future breaking changes.
*   Formatting changes can be handled in a separate PR.
    Example [`94ceec0`](https://github.com/j143/query-spanner-with-java/commit/94ceec092710a3a5ba77682e737fa3e3ba64aed6)
*   New features (e.g., a new cutting edge machine learning algorithm) typically will
    live in [`staging`](./staging) or its equivalent folder for specific
    feature to get some airtime and sufficient testing before a decision is made regarding
    whether they are to migrated to the top-level.
*   When a new contribution is made to the project, the maintenance burden is (by default)
    transferred to the project team. The benefit of the contribution is to be compared
    against the cost of maintaining the feature.

## Code Style

We suggest applying a code formatter to the written code. Generally, this is done automatically.

## Commit Style

This project has linear history throughout. Rebase cleanly and verify that the commit-SHA's
of this public repo are not altered.
A general guideline is never to change a commit inside the official repo, which is
the standard practice. If you have accidentally committed a functionality or tag, let others know.
And create a new commit to revert the functionality of the previous commit but **do not force push**.


### Tags

The tags can be used in combination to one another. These are the only tags available.

  * `minor`: Small changesets with additional functionality
  * `docs`: Changes to the documentation
  * `hotfix`: Introduces changes into the already released versions.


### Commit description

> A commit or PR description is a public record of **what** change is being made and **why**.

#### Structure of the description

##### First Line

1. A summary of what the changeset.
2. A complete sentence, crafted as though it was an order.
    - an imperative sentence
    - Writing the rest of the description as an imperative is optional.
3. Follow by an empty line.

##### Body

It consists of the following.

1. A brief description of the problem solved.
2. Why this is the best approach?.
3. Shortcomings to the approach, if any (important!).

Additional info

4. background information
   - bug/issue/jira numbers
   - benchmark/test results
   - links to design documents
   - code attributions
5. Include enough context for
   - reviewers
   - future readers to understand the Changes.
6. Add PR number, like `Closes #1000`.
