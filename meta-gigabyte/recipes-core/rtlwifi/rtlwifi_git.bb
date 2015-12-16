


DESCRIPTION = "A repo for the newest Realtek rtlwifi codes.	\
This code will build on any kernel 3.0 and newer. It includes the following drivers: \
rtl8192ce, rtl8192se, rtl8192de, rtl8188ee, rtl8192ee, rtl8723ae, rtl8723be, and rtl8821ae."


LICENSE = "Propiretary"

LIC_FILES_CHKSUM = "file://firmware/rtlwifi/Realtek-Firmware-License.txt;md5=9590c633f1c19a55a2b128dfb1098664"
HOMEPAGE = "https://github.com/lwfinger/rtlwifi_new"

PR = "r0"
SRCREV = "b0b00f0f556ab9ab3b801736d1e71dd5f51ed859"


SRC_URI = "https://github.com/lwfinger/rtlwifi_new/archive/troy.zip \
	file://Makefile.patch  \
"

SRC_URI[md5sum] = "eacce3225fed5e5120e367ffaeab50df"
SRC_URI[sha256sum] = "2ed0bc9519a0c521da2cfb86c13fc77572b06bfc2d3fd70f6e3f2f2af781db05"

inherit pkgconfig module


S = "${WORKDIR}/rtlwifi_new-troy"


do_compile () {
    oe_runmake \
	CC="${CC}" \ 
	PWD="${S}" \
	KVER="${KERNEL_VERSION}" \
	KSRC="${STAGING_KERNEL_DIR}" \
	FIRMWAREDIR="${D}/lib/firmware" \
	MODDESTDIR="${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rtlwifi"  \

}


do_install () {
    mkdir -p ${D}/lib/firmware/rtlwifi 
    mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rtlwifi
    oe_runmake \
	CC="${CC}" \ 
	PWD="${S}" \
	KVER="${KERNEL_VERSION}" \
	KSRC="${STAGING_KERNEL_DIR}" \
	FIRMWAREDIR="${D}/lib/firmware" \
	MODDESTDIR="${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rtlwifi"  \
        install


}


FILES_${PN} = "/lib/firmware/rtlwifi/*"

# BBCLASSEXTEND = "native"

