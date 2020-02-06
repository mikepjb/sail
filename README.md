# wind

Use tailwind css classes in Clojure.

## why?

tailwind is a utility first css framework that is a postcss plugin under the
hood. It is intended to be used with autoprefixer (another postcss plugin) and
purgecss.

move makes the tools provided by tailwind available to Clojure projects as a
library, without the you (the library user) having to depend on npm/node. 

## TODO

- [ ] consume all classes from tailwindcss npm (make this easy to re-run as new
  versions are released)
- [ ] purgecss style dead code elimination
- [ ] autocomplete (maybe not part of this lib, autocompleting css classes when
  writing hiccup is important though for this workflow.)

## Plan A

- run postcss/tailwindcss via cli, produce css
- read css using garden
- transform
  - reduce by looking at clojure source code for usage
