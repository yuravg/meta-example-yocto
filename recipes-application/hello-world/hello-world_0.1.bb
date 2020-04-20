SUMMARY = "Simple helloworld application"
DESCRIPTION = "Simple helloworld application"
SECTION = "debug/application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PV = "0.0.1"

SRC_URI = "file://hello_world.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} hello_world.c ${LDFLAGS} -o helloworld
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 helloworld ${D}${bindir}
}
