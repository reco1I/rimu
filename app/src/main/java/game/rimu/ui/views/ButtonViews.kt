package game.rimu.ui.views

import android.view.Gravity
import android.view.ViewGroup
import game.rimu.android.IWithContext
import game.rimu.android.RimuContext


fun IWithContext.IconButton(
    parent: ViewGroup? = this as? ViewGroup,
    init: IconButton.() -> Unit
) = IconButton(ctx).apply {
    parent?.addView(this)
    init()
}

open class IconButton(ctx: RimuContext) : ImageView(ctx)
{

    override val dimensions = super.dimensions.apply {

        height = 50
        width = 70
        padding(15)
    }

    override val rules = super.rules.apply {

        imageTint = "accentColor"
    }

    init
    {
        scaleType = ScaleType.FIT_CENTER
    }
}



// TextButton

fun IWithContext.TextButton(
    parent: ViewGroup? = this as? ViewGroup,
    init: TextButton.() -> Unit
) = TextButton(ctx).apply {
    parent?.addView(this)
    init()
}

open class TextButton(ctx: RimuContext) : TextView(ctx)
{

    override val dimensions = super.dimensions.apply {

        fontSize = 12
        cornerRadius = 12f
        padding(12, 8)
    }

    override val rules = super.rules.apply {

        backgroundColor = "accentColor"
        fontColor = "accentColor"
        fontColorFactor = 0.1f
    }

    init
    {
        gravity = Gravity.CENTER
    }
}