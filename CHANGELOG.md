# Change Log

> Version Information...<br>
> ~~1.0.0.a - {Major Version}.{Minor Version}.{Bugs Fixed/Stuff Implemented}.{Version Type}~~ <br>
> 1.0.0.a - {Phase Complete}.{Sub Phase Complete}.{Hotfix#/Impl#}.{Version Type} <br>
> For details: https://github.com/users/ritesh-debnath-12/projects/2
---

## 1.1.3.a
- Version Information has been changed again.
  - An apology to myself. Never worked with versioning before.
- Added documentation...
  - almost everything done in the previous versions has been documented
- Specific Engine and Transmission Documents can be found in their respect `family` packages
  - Check `src.com.lukxtech.enginefamily` & `src.com.lukxtech.parts.transmissionfamily`
- Changed Unreleased to 0.0.0
- Applied some overloads to CNG Engine setter functions(should be more flexible now)
  - Check `src.com.lukxtech.enginefamily.engines.cng.CNGEngine.java`
- Added License(MIT) for the codebase
  - Check `LICENSE.md`

## 1.1.2.a
### Added
- Added DCT Transmission Implementation
  - Check `src.com.lukxtech.parts.transmissionfamily.transmissions.dct.DualClutchTransmission.java`
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
    - Check `src.com.lukxtech.enginefamily`
- Added Transmission Family with Manual, AMT and CVT Variants
    - Check `src.com.lukxtech.parts.transmissionfamily`