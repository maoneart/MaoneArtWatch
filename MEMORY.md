# MaoneArt Watch Studio — Persistent Memory (`MEMORY.md`)

## Architecture & Key Decisions
- **Workspace**: `/sdcard/www/MaoneArtWatch`
- **Repository**: `https://github.com/maoneart/MaoneArtWatch`
- **Package / App ID**: `id.maoneart.watch` (internal Kotlin package `dev.fitface.studio` preserved for module compatibility)
- **Target Device**: Samsung Galaxy Fit 3 (`SM-R390`, FreeRTOS `256x402`, container limit 4 MiB, custom slots `201–250`).
- **Signing**: Permanent release keystore at `keystore/release.jks` (`alias: maoneart`), release build enabled (`isMinifyEnabled = true`, `isShrinkResources = true`).
- **CI/CD**: `.github/workflows/build_apk.yml` runs unit tests (`:core:model`, `:core:format`, `:core:data`), builds `:app:assembleRelease` (auto-fetching pinned SHA-256 Accessory SDK JARs), and publishes `MaoneArtWatch.apk` to GitHub Releases.

## Recent Milestones & Changes
- **2026-11-26 — Initial Setup & Release Build**:
  - Scaffolded from MIT-licensed `satvikgosai/fitface-studio` with `LICENSE` & `NOTICE.md` preserved.
  - Branded app name (`MaoneArt Watch`), release feed (`maoneart/MaoneArtWatch`), permanent `keystore/release.jks`, and automated GitHub Actions release pipeline (`build_apk.yml`).
