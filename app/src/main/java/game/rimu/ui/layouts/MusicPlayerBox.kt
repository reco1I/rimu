package game.rimu.ui.layouts

import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator
import com.reco1l.framework.android.views.animate
import com.reco1l.framework.android.views.scale
import com.reco1l.framework.android.views.setConstraints
import com.reco1l.framework.android.views.setListeners
import com.reco1l.framework.android.views.setScale
import com.reco1l.framework.graphics.Anchor
import game.rimu.android.RimuContext
import game.rimu.ui.LayerOverlay
import game.rimu.ui.LayoutLayer
import game.rimu.ui.dimensions
import game.rimu.ui.skinningRules
import game.rimu.ui.views.SeekBar
import game.rimu.ui.views.TextView
import kotlin.reflect.KClass

class MusicPlayerBox(ctx: RimuContext) : AttachableLayout(ctx)
{

    override var layer: KClass<out LayoutLayer> = LayerOverlay::class


    val titleText = TextView {

        text = "Title"

    }

    val artistText = TextView {

        text = "Artist"

        setConstraints(
            target = titleText,
            topToTarget = Anchor.BOTTOM
        )

        dimensions.fontSize = 10
        alpha = 0.8f
    }

    val seekBar = SeekBar {

        setConstraints(
            target = artistText,
            topToTarget = Anchor.BOTTOM
        )

        dimensions {
            marginTop = 8
            width = MATCH_PARENT
            height = 20
        }

        progress = 50
        max = 100
    }


    init
    {
        dimensions {
            width = 200
            height = 200
            cornerRadius = 12f

            marginTop = ctx.layouts[TopBarLayout::class].dimensions.height + 10
            marginLeft = 10

            padding(12)
        }

        skinningRules {

            backgroundColor = { data.colours.accentColor.factorInt(0.1f) }
        }
    }


    override fun onAttachedToWindow()
    {
        setConstraints(
            leftToTarget = Anchor.LEFT,
            topToTarget = Anchor.TOP
        )



        super.onAttachedToWindow()

        alpha = 0f
        setScale(0.8f)

        animate {
            scale(1f)
            alpha(1f)

            duration = 300
            interpolator = BounceInterpolator()
        }
    }

    override fun hide()
    {
        animate {

            scale(0.8f)
            alpha(0f)

            duration = 200
            interpolator = DecelerateInterpolator()

            setListeners(onEnd = { super.hide() })
        }
    }
}