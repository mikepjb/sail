# Changelog

## 0.8.12

- include `gap` classes (e.g `gap-x-4`) to provide spacing between rows & columns in grid and flexbox layouts.

## 0.8.11

- include `accent-color` (e.g `accent-blue-500`) classes for coloring checkboxes etc.

## 0.8.10

- basic gradients included (from/to/directions but no advanced %/via etc)
- bugfix: avoid purging hover/focus/active (pseudoclasses)
- sandbox now includes examples of hover states for flat & gradient colored buttons

## 0.8.9

- not a full release, testing gradient generation

## 0.8.8

- watch/build now supports multiple `:paths` like `deps.edn`
- updated color palette to match the latest tailwindcss -50/-950 styles

## pre-0.8.8

_I only started writing this on version 0.8.8, roughly speaking we have_

- watching function to build only the styles that you need during development
- build function to create styles once without watching, usually used for production builds
- normalize css included
- basic tailwind styles included e.g margins/padding/colors/transitions
