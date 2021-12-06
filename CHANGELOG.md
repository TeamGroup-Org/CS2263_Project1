# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.1.0] - 2021-12-05
### Added
- Resources gameBoard.fxml, menu.fxml, and log4j2.xml
- Java classes DataManager, GameBoardController, and MenuController
- Json files for storing serialized board, player1, and player2 objects in between play sessions
### Changed
- UI underwent dramatic changes, introducing stocks, labels centered within the grid pane, and distinct color identities for each corporation
- Code coverage fell dramatically due to many game functions being moved into UI class GameBoardController


## [1.0.0] - 2021-11-14
### Added
- CHANGELOG and README markdown files
- Jacoco, JavaFX, and Gson dependencies to build.gradle
- Java Classes App, Banker, Board, Building, Corporation, Player, Stock, Tile, and TileTray
- Junit Tests for App, Banker, Board, Building, Player, Stock, Corporation, Tile, and TileTray
