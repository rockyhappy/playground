package com.devrachit.playground.common

import com.devrachit.playground.models.Blog

class Constants {
    companion object {
        val blogData = listOf(
            Blog(
                imageUrl = "https://framerusercontent.com/images/vopmns55RUv4POuzl6paePC4YdY.png?scale-down-to=512",
                title="3d Model",
                data="13 October, 2024"
            ),
            Blog(
                imageUrl = "https://miro.medium.com/v2/resize:fit:480/1*YZ4f9YG7RmqxffE-mzph5A.png",
                title="Custom AutoComplete Component",
                data="13 October, 2024"
            )
        )
    }
}