# Change Log

> Version Information...<br>
> ~~1.0.0.a - {Major Version}.{Minor Version}.{Bugs Fixed/Stuff Implemented}.{Version Type}~~ <br>
> 1.0.0.a - {Phase Complete}.{Sub Phase Complete}.{Hotfix#/Impl#}.{Version Type} <br>
> For details: https://github.com/users/ritesh-debnath-12/projects/2

---

## 1.1.4.a
### Added
- Added Abstract Classes for Clutch Parts
  - See `src.com.luktech.powertrain.clutchfamily.abstracts`
### Fixed
- Added `powertrain` directory and moved existing engine and transmission logic
  - Check `src.com.lukxtech.powertrain`
- Removed `parts` folder
- Moved `*Impl` classes to their respective directory (i.e EngineImpl -> enginefamily)
- Added modelNumber as an attribute to the transmission
- Moved `BadModelNumberException` to `src.com.lukxtech.powertrain.common.exception`
  - Reason being, this particular exception is common for all the parts
- Changed DCT documentation version oversight(0.0.0 -> 1.1.2)
- Refactored Transmission w.r.t ModeLNumber
---

## 1.1.3.a
### Added
- Version Information has been changed again.
  - An apology to myself. Never worked with versioning before.
- Added documentation...
  - almost everything done in the previous versions has been documented
- Specific Engine and Transmission Documents can be found in their respect `family` packages
  - Check `src.com.lukxtech.powertrain.enginefamily` & `src.com.lukxtech.powertrain.transmissionfamily`
- Added License(MIT) for the codebase
  - Check `LICENSE.md`

### Fixed
- Ran autoformatter, so codebase should be more "beautiful" now? `(¯\_(ツ)_/¯)`
- Fixed Scanner Object not being closed leading to resource waste.
- Changed Unreleased to 0.0.0
- Applied some overloads to CNG Engine setter functions(should be more flexible now)
  - Check `src.com.lukxtech.powertrain.enginefamily.engines.cng.CNGEngine.java`

---

## 1.1.2.a
### Added
- Added DCT Transmission Implementation
  - Check `src.com.lukxtech.powertrain.transmissionfamily.transmissions.dct.DualClutchTransmission.java`
- Fixed Line issue with Changelog

### Notes:
Very small push. Mostly intended to close the Transmission Family Saga.

---

## 1.0.1.a
### Added
- Added CHANGELOG.md to track changes and updates
- Pushed initial codebase to GitHub

---

## 0.0.0
### Added
- Initial implementation of vehicle configuration system
- Support for custom enums and exceptions
- Added Engine Family with CNG, Diesel, Petrol and Electric Variants
    - Check `src.com.lukxtech.powertrain.enginefamily`
- Added Transmission Family with Manual, AMT and CVT Variants
    - Check `src.com.lukxtech.powertrain.transmissionfamily`