SUMMARY = "Home directory files of root user."
DESCRIPTION = "Provides a files for RootFS: /home/root."
SECTION = "example-yocto/rootfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PV = "0.0.1"

SRC_URI  = "file://bashrc"
SRC_URI += "file://profile"

S = "${WORKDIR}"

INSTALL_DIR = "tmp-config"

do_install () {
    install -d                   ${D}${sysconfdir}/${INSTALL_DIR}/
    install -m 0755 ${S}/bashrc  ${D}${sysconfdir}/${INSTALL_DIR}/
    install -m 0755 ${S}/profile ${D}${sysconfdir}/${INSTALL_DIR}/
}

pkg_postinst_${PN} () {
    install -m 0600 $D${sysconfdir}/${INSTALL_DIR}/bashrc  $D${ROOT_HOME}/.bashrc
    install -m 0600 $D${sysconfdir}/${INSTALL_DIR}/profile $D${ROOT_HOME}/.profile
    rm -rf $D${sysconfdir}/${INSTALL_DIR}/
}
