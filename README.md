<p align="center">
  <img width="460" height="300" src="./sail-logo.png">
</p>

Sail is a pure-Clojure generation tool for creating Tailwind CSS classes. This
includes the ability to only generate the classes that you use by analysing
the source code in your project.

<p align="center">
  <a href="https://clojars.org/com.hypalynx/sail">
    <img alt="Clojars Project" src="https://img.shields.io/clojars/v/com.hypalynx/sail.svg" />
  </a>
  <a href="https://cljdoc.org/d/com.hypalynx/sail/CURRENT">
    <img alt="Clojars Project" src="https://cljdoc.org/badge/com.hypalynx/sail" />
  </a>
</p>

## Getting Started

Include sail as a dependency in your project: 
```clojure
[com.hypalynx/sail "0.8.15"]
{com.hypalynx/sail {:mvn/version "0.8.15"}}
```

Require it in a namespace, like dev.user:
```clojure
(require '[sail.core :as sail]')
```

Include the following in your build sequence to get your css:
```clojure
;; generates all tailwind classes to use in development and re-builds when changes occur
(sail/watch "target/public/styles.gen.css" {:paths ["./src/cljs"]})

;; generates all tailwind classes once, used for production builds
(sail/build "styles.test.gen.css" {:paths ["./src/cljs"]})
```

Write some frontend code using reagent:
```clojure
(defn my-fancy-component-with-styles []
  [:div.bg-red-400.text-red-900.px-4.py-2.rounded.shadow-lg "look at this big red button!"])

```

## Development

If you add dependencies, you must add them to both deps.edn and pom.xml.. ideally we generate the pom file to be
honest but this works for now.

## Technical Differences

Sail aims to be 100% compliant with Tailwind CSS but there are some additional
classes added to make the library easier to use. For example classes with `/`
is them are not valid keywords when used directly so we have alternate tags in
addition to the originals e.g `w-1/2 & w-1-2`
