SUMMARY = "Up sshd after power on."
DESCRIPTION = "Up sshd after power on."
SECTION = "service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PV = "0.0.1"

SRC_URI  = "file://up_sshd.service"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE_${PN} = "up_sshd.service"
SYSTEMD_AUTO_ENABLE_${PN} ?= "enable"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/up_sshd.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += "${systemd_system_unitdir}"

REQUIRED_DISTRO_FEATURES= "systemd"
