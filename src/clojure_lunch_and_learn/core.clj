(ns clojure-lunch-and-learn.core
  (:gen-class))

;;; # DATA

; Vector
["a" "b" "c"]

; List
'(1 2 3)

; Map
{:name "Greenhouse" :startup? true}

; Composable
[{:name "Greenhouse" :startup? true}
 {:name "Google" :startup? false}]

;; # FUNCTIONS

; Invoking functions
(+ 1 1)
(str "aa" "bb")

(+ (* 2 2) (* 3 2))

(defn welcome [name]
  (str "Hi " name "!"))

;; # IMMUTABLE DATA STRUCTURES
(def company {:name "Greenhouse" :startup? true})

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