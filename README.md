# sail

Use Tailwind CSS classes in Clojure, batteries included.

## Why?

I want to use tailwindcss in Clojure without involving extra dependencies e.g
npm/node/javascript/postcss/autoprefixer, especially not when this can be done
in Clojure.

A bit of background to those not familiar with tailwind:  

tailwind is a utility first css framework that is a postcss plugin under the
hood. It is intended to be used with autoprefixer (another postcss plugin) and
purgecss.

sail makes the tools provided by tailwind available to Clojure projects as a
library, without the you (the library user) having to depend on npm/node. 

**Sail is essentially a Clojure port of the Tailwind CSS workflow/build system
I love to use.**

## Getting Started

Include sail as a dependency in your project: 
```
[sail/sail "0.6.5"]
{sail/sail {:mvn/version "0.6.5"}}
```

Require it in a namespace, like dev.user:
```
(require '[sail.core :as sail]')
```

Include the following in your build sequence to get your css:
```
;; generates all tailwind classes to use in development
(sail/generate-styles "styles.gen.css")

;; generates tailwind classes and includes custom css that you provide
(sail/generate-styles-with "styles.gen.css" "my-custom-styles.css")

;; generates all tailwind classes to use in production, this will only generate
;; styles that you've used in your project
(sail/purge-and-generate-styles "styles.gen.css")

;; same as above but with purging (for tailwind css only, custom styles are
;; just appended.
(sail/purge-and-generate-styles-with "styles.gen.css" "my-custom-styles.css")
```

## Implementation notes

Originally I used array-maps to persist order and keep selectors/operators as
maps but as they get bigger, grouping the array-maps revert to hash maps.
Switching to vectors seemed the easier choice.

L600 in full default tailwind.css is where I consider base to end and
components to begin, when .container is first defined.

It looks as though Safair only supports old flex syntax e.g -webkit-box. This
means that multiple keys of the same name are required, where the most modern
sits at the bottom.

display: -webkit-inline-box;
display: inline-flex;

## Releasing

```
rm sail.jar
clj -A:pack mach.pack.alpha.skinny --no-libs --project-path sail.jar
# mvn deploy
CLOJARS_USERNAME="x" CLOJARS_PASSWORD="y" clj -A:deploy
```

## TODO

- [ ] do not assume all source files are in "src"
- [ ] allow reading .cljc files (current implementation causes "Conditional read not allowed exception")
- [ ] ensure font-sans is prefixed as .font-sans
- [ ] consume all classes from tailwindcss npm (make this easy to re-run as new
  versions are released)
- [ ] autoprefix css rules that require it.
- [X] purgecss style dead code elimination
  - N.B using keywords alone with strip out uses in html e.g index.html base
    page.
- [X] describe/find a clean way of tacking this onto a project? e.g already
  using sass?
- [X] cssnano, minification?
- [ ] autocomplete (maybe not part of this lib, autocompleting css classes when
  - most likely a cljs npm language-server will do the trick.
  writing hiccup is important though for this workflow.)
- [X] add in all default colors
- [ ] how to use guide
- [ ] clean up components code (mostly putting things under the correct names)
- [ ] include placeholder classes
- [ ] .container
- [X] .sr-only
- Check :hover\:border-green-800:hover.. seems wrong to have hover at both ends (seen in generated all-project-keywords for sail project)
- [X] include media queries
- [ ] consider adding text-decoration-style (add PR to tailwindcss repo) https://developer.mozilla.org/en-US/docs/Web/CSS/text-decoration-style

## Reference

;; npm view normalize.css version == 8.0.1
;; npm view tailwindcss version == 1.2.0
