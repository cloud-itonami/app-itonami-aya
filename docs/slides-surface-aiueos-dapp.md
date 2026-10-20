# app-slides（面宣言）— itonami（dapp）上の分散型設計

状態: 第 1 スライス実装（2026-10-20）。正本はこの文書。
追跡: Linear JUN-128（親 JUN-116）。

## 位置づけ

app-slides は appview の面（slides-mcp-component、svelte→clj port 済み）。
現状は自己宣言（`slides.state/app-info`）+ UI シェル。判定コアは
「面が宣言するメタデータの整合」—— **app-contacts と同じ面宣言判定の
共通展開**（JUN-128 の展開候補を実行）。

## このスライス: 面宣言の整合判定コア

| 層 | 実体 | 状態 |
|---|---|---|
| 判定コア guest | `aiueos/slides_surface.cljk` — route-count は routes の数と一致 / kind は閉じた集合（appview/worker/component/app）/ source path の明示 / xrpc の claim と実設定の一貫 | **実装済み・実測** |
| 記述子 | `aiueos/slides-surface.edn` | **実装済み** |
| parity | `cljs/test/slides/surface_parity_test.cljk` — `state.cljs` の app-info ピン値が guest 規則を満たす、壊れた宣言は検出される | **実装済み・実測** |

実測: `amu test aiueos/slides_surface.cljk` → **15/15**（jvm-kir / js / wasm）。
parity → 6 assertions / 0 failures。

## 実測メモ（境界の正直な記録）

- parity は **fixture 形** —— `slides.state` は reagent 依存で kbb ロード不可。
  app-info の値（field for field）をオラクルとして使う（app-contacts と同方針）。
- 面宣言の値は Svelte scaffold からの忠実な port。

## 未実装境界

- slides のデッキ操作判定（現状 repo にドメインロジック無し — UI シェルのみ）。
- 面宣言判定の**共通化**（contacts / slides 等の同形状 port 向け 1 つの判定コア
  へ統合）は fleet の別スライス候補 —— 本スライスは repo ごとの形を踏襲。
- mon（DNA）化、aiueos session 載せ（fleet 共通）。
