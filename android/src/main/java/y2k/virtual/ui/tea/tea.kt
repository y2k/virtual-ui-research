package y2k.virtual.ui.tea

import y2k.android.BuildConfig
import y2k.virtual.ui.VirtualHostView
import y2k.virtual.ui.VirtualNode

object SimpleTea {

    fun <Msg, Model> run(hostView: VirtualHostView, comp: TeaComponent<Msg, Model>) {
        var model = comp.init
        fun loop() {
            if (BuildConfig.DEBUG)
                println("LOGX :: TEA :: update() :: $model")

            hostView.update {
                comp.view(model) {
                    val newModel = comp.update(model, it)
                    if (model != newModel) {
                        model = newModel
                        loop()
                    }
                }
            }
        }
        loop()
    }
}

interface TeaComponent<Msg, Model> {
    val init: Model
    fun view(model: Model, dispatch: (Msg) -> Unit): VirtualNode
    fun update(model: Model, msg: Msg): Model
}
