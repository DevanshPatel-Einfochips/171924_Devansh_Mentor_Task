SUMMARY = "Custom Networking Image for BeagleBone"
DESCRIPTION = "An image based on core-image-minimal that includes OpenSSH and basic networking tools."

# Pull in the base requirements from core-image-minimal
require recipes-core/images/core-image-minimal.bb

# Add the SSH server feature
IMAGE_FEATURES += "ssh-server-dropbear"

# Add your specific networking packages 
# (Note: tcpdump is left out here so your build won't fail if you haven't added meta-openembedded yet)
IMAGE_INSTALL += " \
    kernel-modules \
    linux-firmware \
    iproute2 \
    iptables \
    ethtool \
    curl \
"

# Optional: Allow passwordless root login for local development
EXTRA_IMAGE_FEATURES += "empty-root-password allow-empty-password allow-root-login"
