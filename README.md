meta-silverline
===============


yocto reciepes for Silverline Hub

This meta folder will build Silverline Hub on Galileo board

You need to downlooad and install Galileo bsp files, and place this folder with the other 'meta-' folders

Then you need to edit the file yocto/conf/layers.conf add the full path to the new folder at the bottom of the BBLAYERS assignment.

```
BBLAYERS ?= " \
  ... /meta-clanton_v1.0.1/poky/meta \

...

  ... /meta-clanton_v1.0.1/meta-clanton-bsp \
  ... /meta-clanton_v1.0.1/meta-silverline \
  "
```

then run 

`bitbake linux-full-galileo`


