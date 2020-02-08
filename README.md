# sail

Use tailwind css classes in Clojure.

## why?

I want to use tailwindcss in Clojure without involving extra dependencies e.g
npm/node/javascript/postcss/autoprefixer, especially not when this can be done
in Clojure.

A bit of background to those not familiar with tailwind:  

tailwind is a utility first css framework that is a postcss plugin under the
hood. It is intended to be used with autoprefixer (another postcss plugin) and
purgecss.

move makes the tools provided by tailwind available to Clojure projects as a
library, without the you (the library user) having to depend on npm/node. 

**Sail is essentially a Clojure port of the Tailwind CSS workflow/build system
I love to use.**

## TODO

- [ ] consume all classes from tailwindcss npm (make this easy to re-run as new
  versions are released)
- [ ] autoprefix css rules that require it.
- [ ] purgecss style dead code elimination
- [ ] describe/find a clean way of tacking this onto a project? e.g already
  using sass?
- [ ] cssnano, minification?
- [ ] autocomplete (maybe not part of this lib, autocompleting css classes when
  writing hiccup is important though for this workflow.)

## Plan A

- run postcss/tailwindcss via cli, produce css
- read css using garden
- transform
  - reduce by looking at clojure source code for usage

## Plan B

- generate your own css file based on a similar system.
- compare it to the minified distributed version for comparison of types.

## Usage [work in progress]

`[sail "0.1.0"]`
`{sail {:mvn/version "0.1.0"}}`

## Reference

;; npm view normalize.css version == 8.0.1
;; npm view tailwindcss version == 1.2.0
