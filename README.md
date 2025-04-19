# Low Level Design

- Mixture of design & coding
- "Programming is coding across time" ~ Google

---

_3 Factors_ to call a piece of code good/bad:

- Readability
- Extensibility
- Correctness

### Readability

- Easy to debug errors & warnings
- Easy to read and understand by other team members
- Easy to change
- Easy to write test cases
- NOT to make a black box
- Bad code means more refactoring
- Increases code of engineering time

### Extensibility

- When a requirement changes slightly then without much code changes/major refactoring you should be able to add new features

> Your reputation is built on your work.
> And your work is documented by your code.

So let your code speak for itself.

### Correctness

- Reputation of engineer is measured in both short term and long term based on No of bugs from customers in production
- Team has to be reliable
- Code must work & there are backups

---

Under the umbrella of low level design, we will be looking at:

- Guiding principles
- Design patterns

---

## Requirement

Taking a game and having the ability to play it through AI.

### Engineering questions?
- What kind of APIs should you be exposing?
- 