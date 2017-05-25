require recipes-bsp/u-boot/u-boot.inc

DESCRIPTION = "U-Boot port for C.H.I.P. boards"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

DEPENDS += "dtc-native"
PROVIDES += "u-boot"

UBOOT_VERSION ?= "2016.01"
PV = "${UBOOT_VERSION}+git${SRCPV}"

SRCREV ?= "c23364e2cd21ef74f7405fa03e537582f062c4c0"
BRANCH ?= "nextthing/2016.01/chip"
SRC_URI = " \
	git://github.com/NextThingCo/CHIP-u-boot.git;branch=${BRANCH} \
	file://gcc6.patch \
	"
S = "${WORKDIR}/git"

do_compile_append() {
    install ${B}/spl/${SPL_BINARY} ${B}/${SPL_BINARY}
}

COMPATIBLE_MACHINE = "chip"
