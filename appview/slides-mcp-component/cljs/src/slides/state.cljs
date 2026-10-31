(ns slides.state
  (:require [reagent.core :as reagent]))

;; Static app descriptor (port of the `app` object in +page.svelte).
(def app-info
  {:title "Slides Mcp Component"
   :project "itonami-aya"
   :name "slides-mcp-component"
   :kind "appview"
   :route-count 0
   :routes []
   :vars []
   :xrpc true
   :relative-path "appview/slides-mcp-component/cljs/src/slides/ui.cljs"})
