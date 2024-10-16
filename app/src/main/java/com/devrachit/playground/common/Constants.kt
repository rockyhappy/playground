package com.devrachit.playground.common

import com.devrachit.playground.models.Blog

class Constants {
    companion object {
        val blogData = listOf(
            Blog(
                imageUrl = "https://framerusercontent.com/images/vopmns55RUv4POuzl6paePC4YdY.png?scale-down-to=512",
                title="3d Model",
                data="13 October, 2024",
                route = "model_3d"
            ),
            Blog(
                imageUrl = "https://miro.medium.com/v2/resize:fit:480/1*YZ4f9YG7RmqxffE-mzph5A.png",
                title="Custom AutoComplete Component",
                data="13 October, 2024",
                route = "auto_complete_component"
            ),
            Blog(
                imageUrl = "https://imgs.search.brave.com/0ewx1tif2omDRl6_UXSQu1gXRA7BFkBDXdCMIeN1AB0/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9qb2hu/Y29kZW9zLmNvbS93/cC1jb250ZW50L3Vw/bG9hZHMvMjAyMS8w/Ny9kcmF3ZXItY29t/cG9zZS1hbmRyb2lk/LXR1dG9yaWFsLXRo/dW1ibmFpbC0xMDI0/eDU3Ni5wbmc",
                title="Magic Drawer",
                data="13 October, 2024",
                route = "magic_drawer"
            ),
        )
    }
}