### Welcome to QuantAnalysis!

This is my attempt to create an analyzer for the equities market. I may add bonds, and derivatives in the, well, _future_.

I will be using a Jersey Server with a Postgres backend, and a React frontend. This will also be a learning experience since I havent created a complicated web app with those tools!

#### API Layout:
- `equity/` - will list all the equities and their details
- `equity/{equity}` - will list the details of the `{equity}`
- `equity/{equity}/algorithms` - will list the algorithms available for the selected `{equity}`
- `equity/{equity}/algorithms/{algorithm_id}` - will perform an algorithmic analysis with an algorithm that has an id of `{algorithm_id}` on the selected `{equity}` and return results.

#### Current Goals (Milestone 1):

- [x] Create the securities master database ()
- [ ] Populate the database
- [ ] Create REST endpoints in the WebApp that generate JSON objects
- [ ] Write a Simple Moving Average algorithm.
- [ ] Create a front end that will consume this.
