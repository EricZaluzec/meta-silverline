DESCRIPTION = "A Lua client library for the redis key value storage system."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=29d3422f4961a20e88265017e26b4265"
HOMEPAGE = "https://github.com/nrk/redis-lua"

PR = "rc1"

DEPENDS = "lua"

SRC_URI = "https://github.com/nrk/redis-lua/archive/v${PV}.tar.gz \
	file://lua-redis.pc \
"


INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"


SRC_URI[md5sum] = "9fcc177ebb2ce936c178231ba445fb62"
SRC_URI[sha256sum] = "5eb6cb7cd0eda659cef7c231e43cd5f491cbd04804034d1c80134a1604e5cb5e"

S = "${WORKDIR}/redis-lua-${PV}"
luadir = "/lua/5.2"

do_install () {


    install -d ${D}${datadir}${luadir}
    install -m 0644 ${S}/src/redis.lua ${D}${datadir}${luadir}

    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${WORKDIR}/lua-redis.pc ${D}${libdir}/pkgconfig/

}

FILES_${PN} = "${datadir}${luadir}/redis.lua \
"


