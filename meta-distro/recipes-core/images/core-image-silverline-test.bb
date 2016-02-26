DSCRIPTION = "A fully functional image to be placed on SD card"

DISTRO_NAME = "Silverline Linux"


IMAGE_LINGUAS = ""

LICENSE = "GPLv2"

inherit core-image


DISTRO_FEATURES += "bluetooth usbgadget usbhost wifi zeroconf pci 3g"

IMAGE_FEATURES += "package-management"
IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL = "packagegroup-core-boot"
IMAGE_INSTALL += "${ROOTFS_PKGMANAGE_BOOTSTRAP}"
IMAGE_INSTALL += "${CORE_IMAGE_EXTRA_INSTALL}"
IMAGE_INSTALL += "kernel-modules"
IMAGE_INSTALL += "linux-firmware"
IMAGE_INSTALL += "ethtool"
IMAGE_INSTALL += "pciutils"
IMAGE_INSTALL += "wireless-tools"
IMAGE_INSTALL += "wpa-supplicant"
IMAGE_INSTALL += "ppp"
IMAGE_INSTALL += "openssh"
IMAGE_INSTALL += "usbutils"
IMAGE_INSTALL += "util-linux"
IMAGE_INSTALL += "makedevs"
IMAGE_INSTALL += "tzdata"
IMAGE_INSTALL += "cronie"
IMAGE_INSTALL += "logrotate"
IMAGE_INSTALL += "rsync"
IMAGE_INSTALL += "avahi-daemon"
IMAGE_INTSALL += "usb-modeswitch"
IMAGE_INSTALL += "redis"
IMAGE_INSTALL += "lighttpd"
IMAGE_INSTALL += "sudo"
IMAGE_INSTALL += "sensorhub"
 
EXTRA_IMAGEDEPENDS_append_quark = " grub-conf "
ROOTFS_POSTPROCESS_COMMAND_append_quark += " install_silverline_repo; "

install_silverline_repo() {
   echo "src/gz all http://silverline-support.dyndns.org/deploy/test/daisy/quark/ipk/all" > ${IMAGE_ROOTFS}/etc/opkg/base-feeds.conf
   echo "src/gz i586  http://silverline-support.dyndns.org/deploy/test/daisy/quark/ipk/corei7-64" >> ${IMAGE_ROOTFS}/etc/opkg/base-feeds.conf
   echo "src/gz quark http://silverline-support.dyndns.org/deploy/test/daisy/quark/ipk/valleyisland_64" >> ${IMAGE_ROOTFS}/etc/opkg/base-feeds.conf
}


