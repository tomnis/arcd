# arcd
arc diagram

An arc diagram is a visualizatiom method for representing complex repetitions in strings.

- Diverse applications to music, DNA, compiled code, etc
- scale efficiently for highly repeated subsequence

- To avoid a potentially noisy diagram, visualize only a subset of all possible pairs of matching
  substrings.

- Definition 1: a `maximal matching pair` is a pair of substrings of s, (x, y) which are
  - identical
  - non-overlapping: (do not intersect)
  - consecutive: (there is no identical substring z that started between the beginning of x and the beginning of y
  - maximal: (there do not exist longer identical (x', y') with x' containing x and y' containing y.
  - "123a123" -> "123" substrings are maximal, but "12" substrings are not

- Definition 2: a repetition region `r` is a substring of `s` such that `r` consists of a string `p` repeated 2 or more times
  each repetition of `p` is a fundamental substring for `r`.
  "010101" is  a repetition region. each "01" is a fundamental substring.

- Definition 3: an Essential matching pair is a pair of substrings of `s`, `(x, y)` which are
  - maximal matching pair not contained in any repetition region
  - Or, maximal matching pair contained in the same fundamental substring of any repetition region
  - Or, two consecutive fundamental substrings in the same repetition region.