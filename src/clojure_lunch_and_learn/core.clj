(ns clojure-lunch-and-learn.core
  (:gen-class))

;;; DATA

; Vector
["a" "b" "c"]

; List
'(1 2 3)

; Keyword (similar
:special-snowflake

; Map
{:name "Greenhouse" :city "New York"}

; Set
#{"fred" "ethel"}

; Composable
[{:name "Greenhouse" :city "New York"}
 {:name "Dropbox" :city "San Francisco"}]










;;; EXAMPLES

; HTTP Headers
{:user-agent "Mozilla/5.0 (Macintosh)",
 :cache-control "max-age=0",
 :host "localhost:3000",
 :accept-encoding "gzip, deflate, sdch, br",
 :connection "keep-alive",
 :accept-language "en-US,en;q=0.8",
 :accept "text/html"}







; HoneySQL
{:select [:a :b :c]
 :from [:foo]
 :where [:= :f.a "baz"]}




; Hiccup HTML
; <div id="hello" class="content"><p>Hello world!</p></div>
[:div {:id "hello", :class "content"} [:p "Hello world!"]]






; Onyx DAG
[[:in :split-by-spaces]
 [:split-by-spaces :mixed-case]
 [:mixed-case :loud]
 [:mixed-case :question]
 [:loud :loud-output]
 [:question :question-output]]


;; # FUNCTIONS

; Invoking functions
(+ 1 1)
(str "aa" "bb" "cc" "dd")

(+ (* 2 2) (* 3 2))

(defn welcome [name]
  (str "Hi " name "!"))

;; # IMMUTABLE DATA STRUCTURES
(def company {:name "Greenhouse" :city "New York"})

(assoc company :city "New York")

(dissoc company :name)

;; How does this work?
;;  - Structural sharing

;; Why would you want to do this?
;;  - knowing that your data structure
;;    is not going to change means
;;    it is shareable

;; Other example of immutability
;;  - Git is a good example; just
;;    because you changed some
;;    code in your codebase, you doesn't
;;    mean you overwrite

;; Talk about examples of *mutability*
;; in Ruby (and what attempts are made
;; to defend against it like freezing)


;; # SO HOW DO YOU MANAGE CHANGE?
(def greenhouse-initial-state
  {:employees 200})

(def greenhouse (atom greenhouse-initial-state))

(comment
  (swap! greenhouse update :employees inc))

;; SHOW HOW REFS WORK?

;; TALK ABOUT HOW CLOJURE PROGRAMS TEND TO LOOK
;;  - 90% your code ends up being pure
;;    functions that don't have side-effects.
;;    And then there's a small part of your code
;;    that deals with changing the world and
;;    it's isolated

;; # MACROS
(defmacro unless
  [pred then else]
  `(if (not ~pred) ~then ~else))

;; One of the benefits of LISP.
;; Because of this property, new
;; language features can be added
;; horizontally through libraries.
;; Core features of the language are
;; implemented this way: core.async
;; and clojure.spec.