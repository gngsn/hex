package com.gngsn.ditto.hexagonal

//@AnalyzeClasses(packages = ["com.gngsn.ditto"])
//class HexagonalTest {
//
//    @ArchTest
//    fun layersValidator(): ArchRule = Architectures.layeredArchitecture()
//            .layer("Entities").definedBy("..entity..")
//        .layer("Repositories").definedBy("..repository..")
//        .layer("Configs").definedBy("..configuration..")
//        .whereLayer("Repositories").mayOnlyBeAccessedByLayers("Configuration")
//        .whereLayer("TransportLayers").mayOnlyBeAccessedByLayers("Configuration")
//        .whereLayer("Configs").mayNotBeAccessedByAnyLayer()
//}