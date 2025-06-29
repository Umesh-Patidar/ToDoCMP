@file:OptIn(InternalResourceApi::class)

package todocmp.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.ResourceItem

private const val MD: String = "composeResources/todocmp.composeapp.generated.resources/"

internal val Res.drawable.app_icon: DrawableResource by lazy {
      DrawableResource("drawable:app_icon", setOf(
        ResourceItem(setOf(), "${MD}drawable/app_icon.png", -1, -1),
      ))
    }

internal val Res.drawable.compose_multiplatform: DrawableResource by lazy {
      DrawableResource("drawable:compose_multiplatform", setOf(
        ResourceItem(setOf(), "${MD}drawable/compose-multiplatform.xml", -1, -1),
      ))
    }

internal val Res.drawable.ic_empty_icon: DrawableResource by lazy {
      DrawableResource("drawable:ic_empty_icon", setOf(
        ResourceItem(setOf(), "${MD}drawable/ic_empty_icon.png", -1, -1),
      ))
    }

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("app_icon", Res.drawable.app_icon)
  map.put("compose_multiplatform", Res.drawable.compose_multiplatform)
  map.put("ic_empty_icon", Res.drawable.ic_empty_icon)
}
